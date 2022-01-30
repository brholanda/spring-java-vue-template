export class Profile {
  constructor({
    id = null,
    name = null
  } = {}) {
    this.id = id;
    this.name = name;
  }
}

export function cloneProfile(data) {
  if (Array.isArray(data)) {
    var list = []
    data.forEach(element => {
      list.push(new Profile(element))
    });
    return list;
  }
  return new Profile(data);
}

export function createProfile(data) {
  if (Array.isArray(data)) {
    var list = []
    data.forEach(element => {
      list.push(Object.freeze(new Profile(element)))
    });
    return list;
  }
  return Object.freeze(new Profile(data));
}