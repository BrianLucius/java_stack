package net.brianlucius.abstract_art;

public class Sculpture extends Art {
	private String material;

	public Sculpture(String title, String author, String description, String material) {
		super(title, author, description);
		this.material = material;
	}
	
	public void viewArt() {
		System.out.printf("A %s sculpture by %s, titled: %s.\n", this.material, getAuthor(), getTitle());
		System.out.printf("The description of the work is: %s.\n\n", getDescription());
	}
	
}
