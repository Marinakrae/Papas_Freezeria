export class Nivel{

  id_Nivel?: string | undefined;
  dificuldade?: string | undefined;
  pontos?: string | undefined;
  desempenho_nivel?: string | undefined;


  constructor(id_Nivel?: string, dificuldade?: string, pontos?: string, desempenho_nivel?: string) {
    this.id_Nivel = id_Nivel;
    this.dificuldade = dificuldade;
    this.pontos = pontos;
    this.desempenho_nivel = desempenho_nivel;
  }

}
