export class Cliente{

  id?: string | undefined;
  nome?: string | undefined;
  endereco?: string | undefined;
  ativo?: boolean | undefined;

  constructor(id?: string, nome?: string, endereco?: string, ativo?: boolean) {
    this.id = id;
    this.nome = nome;
    this.endereco = endereco;
    this.ativo = ativo;
  }

}
