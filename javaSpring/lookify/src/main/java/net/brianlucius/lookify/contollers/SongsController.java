package net.brianlucius.lookify.contollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.brianlucius.lookify.models.Song;
import net.brianlucius.lookify.services.SongService;

@Controller
public class SongsController {
	
	@Autowired
	private SongService songService;
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songList = songService.allSongs();
		model.addAttribute("songList", songList);
		return "dashboard.jsp";
	}
	
	@GetMapping("/songs/new")
	public String addNew(@ModelAttribute("song") Song song) {
			return "new.jsp";
		}
	
	@PostMapping("/songs/new")
	public String addNew(@Valid @ModelAttribute("song") Song song,
			BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		}
		songService.createSong(song);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Song song = songService.getOne(id);
		model.addAttribute("song", song);
		return "show.jsp";
	}
	
	@DeleteMapping("/songs/{id}")
	public String delete(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/search")
	public String searchByArtist(@RequestParam("artist") String artist, Model model) {
		List<Song> songList = songService.searchByArtist(artist);
		model.addAttribute("songList", songList);
		model.addAttribute("searchArtist", artist);
		return "search.jsp";
	}
	
	@GetMapping("/search/topTen")
	public String topTen(Model model) {
		List<Song> songList = songService.topTen();
		model.addAttribute("songList", songList);
		return "topten.jsp";
	}
	
	
	
}
