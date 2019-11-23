package Aeroporto;

import java.util.Arrays; 
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Quantos avioes irao sair?");
		int m = in.nextInt();
		System.out.println("Digite agora o horario de saida dos avioes: (em milissegundos)");
		int horarioSaida [] = new int [m];
		for(int i=0; i<m; i++) {
			horarioSaida[i] = in.nextInt();
		}
		
		System.out.println("Quantos avioes irao chegar?");
		int n = in.nextInt();
		System.out.println("Digite o horario de chegada dos avioes: (em milissegundos)");
		int horarioChegada [] = new int[n];
		for(int i=0; i<n; i++) {
			horarioChegada[i]=in.nextInt();
		}
		
		System.out.println("Qual o numero de pistas do aeroporto?");
		int x = in.nextInt();
		
		Aeroporto aeroporto = new Aeroporto(x);
		
		Arrays.sort(horarioSaida);
		Arrays.sort(horarioChegada);
		
		//pra setar prioridades nas Threads
		int a = 0, b = 0;
		a = m/10;
		b = n/10;
		
		int prioridade = 10;
		int contador = 0;
		for(int i=0; i<m; i++) {
			
			//margem de erro
			if(prioridade == 0) {
				prioridade=1;
			}
			
			contador++;
			Aviao threadR = new Aviao("@LucasIndo", horarioSaida[i], "decolar", aeroporto);
			Thread tr = new Thread(threadR);
			tr.setPriority(prioridade);
			tr.start();
			if(contador==a) {
				contador=0;
				prioridade--;
			}
			
		}
		
		prioridade = 10;
		contador = 0;
		for(int i=0; i<n; i++) {
			
			//margem de erro
			if(prioridade == 0) {
				prioridade=1;
			}
			
			contador++;
			Aviao threadR = new Aviao("@LucasVindo", horarioChegada[i], "aterrisar", aeroporto);
			Thread tr = new Thread(threadR);
			tr.setPriority(prioridade);
			tr.start();
			if(contador==b) {
				contador=0;
				prioridade--;
			}
		}
		
		
		
		
	}

}
