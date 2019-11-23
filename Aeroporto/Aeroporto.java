package Aeroporto;

public class Aeroporto {
	private boolean pistas [];
	private boolean permissao = false;
	
	public Aeroporto (int q) {
		this.pistas = new boolean [q];
		for(int i=0; i<this.pistas.length; i++) {
			this.pistas[i]=false;
		}
	}
	
	public long decolar (int horario) {
		
		long tempo = System.currentTimeMillis();
		while(!permissao) {
			try {
				for(int i=0; i<this.pistas.length; i++) {
					if(this.pistas[i]==false) {
						permissao = true;
						this.pistas[i]=true;
					}
				}
				if(!permissao) wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		notifyAll();
		return System.currentTimeMillis() - tempo - 500;
	}
	
	public long aterrisar(int horario) {		
		long tempo = System.currentTimeMillis();
		while(!permissao) {
			try {
				for(int i=0; i<this.pistas.length; i++) {
					if(this.pistas[i]==false) {
						permissao = true;
						this.pistas[i]=true;
					}
				}
				if(!permissao) wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		notifyAll();
		return System.currentTimeMillis() - tempo - 500;
	}

	
	
}
