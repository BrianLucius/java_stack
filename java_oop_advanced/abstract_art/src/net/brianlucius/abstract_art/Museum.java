package net.brianlucius.abstract_art;

import java.util.ArrayList;
import java.util.Random;

public class Museum {

	public static void main(String[] args) {
		ArrayList<Art> museum = new ArrayList<Art>();
		
		Painting painting1 = new Painting("Water Lillies","Monet","Lillies on a pond","Watercolor");
		museum.add(painting1);
		
		Painting painting2 = new Painting("Mona Lisa","Leonardo DaVinci","A smiling woman","Oil");
		museum.add(painting2);
		
		Painting painting3 = new Painting("Self Portrait","Picasso","Self-portrait","Pastels");
		museum.add(painting3);
		
		Sculpture sculpture1 = new Sculpture("David","Leondardo DaVinci","A perfect man","Marble");
		museum.add(sculpture1);
		
		Sculpture sculpture2 = new Sculpture("King Tutankamen","Unknown","A sarcophogas for an Egyptian King","Clay and Gold");
		museum.add(sculpture2);

		
		//Shuffle Museum
		Random randomNum = new Random();
		
		for (int i=0; i < museum.size(); i++) {
			int pos1 = randomNum.nextInt(museum.size());
			int pos2 = randomNum.nextInt(museum.size());
			
			Art temp = museum.get(pos2);
			museum.set(pos2, museum.get(pos1));
			museum.set(pos1, temp);
		}

		//View shuffled museum
		for (Art piece : museum) {
			piece.viewArt();
		}
	}

}
