package net.brianlucius.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.brianlucius.lookify.models.Song;
import net.brianlucius.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public List<Song> allSongs() {
		return songRepository.findByOrderByTitle();
	}
	
	public Song createSong(Song data) {
		return songRepository.save(data);
	}
	
	public Song getOne(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	
	public Song updateSong(Song data) {
		return songRepository.save(data);
	}
	
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}
	
	public List<Song> searchByArtist(String artist) {
		return songRepository.findByArtistContainingOrderByTitle(artist);
	}
	
	public List<Song> topTen(){
		return songRepository.findTop10ByOrderByRatingDesc();
	}

}
