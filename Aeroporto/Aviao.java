package Aeroporto;

public class Aviao implements Runnable {
	private String nome;
	private int horario;
	private String funcao;
	private Aeroporto aeroporto;

	public Aviao(String nome, int horario, String funcao, Aeroporto aeroporto) {
		this.nome = nome;
		this.horario = horario;
		this.funcao = funcao;
		this.aeroporto = aeroporto;
	}

	@Override
	public void run() {
		while(true) {
			if(System.currentTimeMillis()>=this.horario) {
				long realizou;
				if(this.funcao.equals("decolar")) {
					realizou = this.aeroporto.decolar(this.horario);
				} else {
					realizou = this.aeroporto.aterrisar(this.horario);
				}
				System.out.println("Aviao "+this.funcao+". Horario de saida esperado: "+this.horario+". Horario de saida real: "+(this.horario + realizou)+". Ataso: "+realizou);				
				break;
			}
		}
	}
}
