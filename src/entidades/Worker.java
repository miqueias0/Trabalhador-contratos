package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.WorkerLevel;

public class Worker {
	private String nome;
	private WorkerLevel level;
	private double salarioBase;
	private Departamento departamento;
	private List<HoraContratada> contratos = new ArrayList<>();
	public Worker() {
	}
	public Worker(String nome, WorkerLevel level, double salarioBasico, Departamento dopartamento) {
		this.nome = nome;
		this.level = level;
		this.salarioBase = salarioBasico;
		this.departamento = dopartamento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public WorkerLevel getLevel() {
		return level;
	}
	public void setLevel(WorkerLevel level) {
		this.level = level;
	}
	public double getSalarioBase() {
		return salarioBase;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public List<HoraContratada> getContrato() {
		return contratos;
	}
	public void addContrato(HoraContratada contrato) {
		contratos.add(contrato);
	}
	public void removerContrato(HoraContratada contrato) {
		contratos.remove(contrato);
	}
	public double renda(Integer ano, Integer mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (HoraContratada c : contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if (c_ano == ano && c_mes == mes) {
				soma += c.valorTotal();
			}
		}
		
		return soma;
	}
	
}
