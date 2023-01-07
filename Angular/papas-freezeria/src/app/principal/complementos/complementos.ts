export class Complementos{

  id_complementos?: string | undefined;
  complemento1?: string | undefined;
  complemento2?: string | undefined;
  complemento3?: string | undefined;

  constructor(id_complementos?: string, complemento1?: string, complemento2?: string, complemento3?: string) {
    this.id_complementos = id_complementos;
    this.complemento1 = complemento1;
    this.complemento2 = complemento2;
    this.complemento3 = complemento3;
  }

}
