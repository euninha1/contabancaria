package application;

import java.util.Locale;
import java.util.Scanner;

import model.DomainException;
import model.entities.ContaBancaria;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in); 

		System.out.println("Insira os dados da conta"); 
		System.out.print("Número da conta: ");
		int num = sc.nextInt(); 
		System.out.print("Nome: ");
		sc.nextLine(); 
		String nome = sc.nextLine();
		System.out.print("Saldo Incial: ");
		double saldo = sc.nextDouble(); 
		System.out.print("Limite do saque: ");
		double limitesaque = sc.nextDouble(); 
		
		ContaBancaria cont = new ContaBancaria(num, nome, saldo, limitesaque); 
		
		System.out.println();
		System.out.print("Insira o valor do saque: ");
		double saque = sc.nextDouble(); 
		try { 
			cont.retirar(saque); 
			System.out.println("Novo saldo: "+ String.format("%.2f", cont.getSaldo()));
		}
		catch (DomainException e) { 
			System.out.println(" Error de retirada: " + e.getMessage());
		}
	
		sc.close();
	}

}
