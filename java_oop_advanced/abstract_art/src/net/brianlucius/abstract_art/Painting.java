package net.brianlucius.abstract_art;

public class Painting extends Art {
	private String paintType;

	public Painting(String title, String author, String description, String paintType) {
		super(title, author, description);
		this.paintType = paintType;
	}
	
	public void viewArt() {
		System.out.printf("A %s painting by %s, titled: %s.\n", this.paintType, getAuthor(), getTitle());
		System.out.printf("The description of the work is: %s.\n\n", getDescription());
	}
	
}
