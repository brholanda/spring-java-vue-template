import {
  createProfile
} from "./Profile";

export class User {
  constructor({
    id = null,
    nome = null,
    email = null,
    profile = createProfile(),
    dataCriacao = null,
    ativo = null
  } = {}) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.profile = profile;
    this.dataCriacao = dataCriacao;
    this.ativo = ativo;
  }
}

export function cloneUser(data) {
  if (Array.isArray(data)) {
    var list = []
    data.forEach(element => {
      list.push(new User(element))
    });
    return list;
  }
  return new User(data);
}

export function createUser(data) {
  if (Array.isArray(data)) {
    var list = []
    data.forEach(element => {
      list.push(Object.freeze(new User(element)))
    });
    return list;
  }
  return Object.freeze(new User(data));
}