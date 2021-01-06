package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import entidades.Departamento;
import entidades.HoraContratada;
import entidades.Worker;
import entidades.enums.WorkerLevel;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Worker trabalhador = new Worker();
		Departamento Departamento = new Departamento();
		WorkerLevel nivel = null;
		Date data = new Date();
		HoraContratada horaContratada = new HoraContratada();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/yyyy");
		System.out.print("Entre com o departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Entre com os dados do trabalhador:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Level: ");
		char level = sc.next().charAt(0);
		System.out.print("Salario base: ");
		double salarioBase = sc.nextDouble();
		if (level == 'J') {
			nivel = WorkerLevel.JUNIOR;
		} else if (level == 'M') {
			nivel = WorkerLevel.MID_LEVEL;
		} else if (level == 'S') {
			nivel = WorkerLevel.SENIOR;
		}
		Departamento = new Departamento(nomeDepartamento);
		trabalhador = new Worker(nome, nivel, salarioBase, Departamento);
		System.out.print("Esse trabalhador tem quantos contratos? ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			sc.nextLine();
			System.out.println("Entre com os dados do #" + i + " contrato:");
			System.out.print("Data (DD/MM/AAAA): ");
			data = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valor = sc.nextDouble();
			System.out.print("Duração (horas): ");
			int horas = sc.nextInt();
			horaContratada = new HoraContratada (data, valor, horas);
			trabalhador.addContrato(horaContratada);
		}
		System.out.print("Entre com o mês e ano para caucular a renda (MM/AAAA): ");
		data = sdf1.parse(sc.next());
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		Integer mes = cal.get(Calendar.MONTH);
		Integer ano = cal.get(Calendar.YEAR);
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Renda de " + sdf.format(data) + ": " + trabalhador.renda(ano, mes));
		
		sc.close();
	}

}
