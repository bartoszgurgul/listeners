package pl.javastart.jdbc.data;

public class City {
	private String name;
	private int population;
	
	public String getName() {
		return name;
	}
	public int getPopulation() {
		return population;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
	public City() {
		this.name = null;
	}
	public City(String name, int population) {
		this.name = name;
		this.population = population;
	}

}
