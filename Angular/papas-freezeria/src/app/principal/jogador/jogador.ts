export class Jogador{

  id_Jogador?: string | undefined;
  nome?: string | undefined;
  email?: string | undefined;
  senha?: string | undefined;
  permissao?: string | undefined;
  token?: string | undefined;

  constructor(id_Jogador?: string, nome?: string, email?: string, senha?: string, permissao?: string, token?: string) {
    this.id_Jogador = id_Jogador;
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.permissao = permissao;
    this.token = token;
  }

}
