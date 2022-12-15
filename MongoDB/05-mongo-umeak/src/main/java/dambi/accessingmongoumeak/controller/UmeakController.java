package dambi.accessingmongoumeak.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dambi.accessingmongoumeak.model.*;

@RestController 
@RequestMapping(path = "/gabonak")
public class UmeakController {
	@Autowired 
	private UmeaRepository umeaRepository;
	
	@GetMapping(path = "/umeguztiak")
	public @ResponseBody Iterable<Umea> getAllUsers() {
		// This returns a JSON or XML with the users
		return umeaRepository.findAll();
	}

    @GetMapping(path = "/umearenOpariak/{umeaId}")
	public @ResponseBody Iterable<Umea> getAllOpariak( @PathVariable long umeaId) {
		
        // This returns a JSON or XML with the users
		return umeaRepository.findByOpariak(umeaId);
	}

	@PostMapping(path = "/umeberria") // Map ONLY POST Requests
	public @ResponseBody String addNewUser(@RequestParam String izena, @RequestParam List<String> opariak) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Umea u = new Umea();
		u.setIzena(izena);
		u.setOpariak(opariak);
		umeaRepository.save(u);
		return "Saved";
	}
	
	@PutMapping(value = "/opariberria/{umeaId}")
	public ResponseEntity<Umea> updateUmea(@Valid @RequestBody String opBerria, @PathVariable String umeaId) {
		try {
			Umea umea= umeaRepository.findById(umeaId);
			List<String> opariak=umea.getOpariak();
			opariak.add(opBerria);
			umea.setOpariak(opariak);
			umeaRepository.save(umea);

			return ResponseEntity.ok().build();

		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(path = "/delete/{umearenIzena}")
	public @ResponseBody long deleteUmea(@PathVariable String umearenIzena) {
		try {
			long zenbat = umeaRepository.delete(umearenIzena);
			System.out.println("Ezabatutako ume kopurua🔆: "+zenbat);
			return zenbat;

		} catch (Exception ex) {
			System.out.println("Errorea " + umearenIzena + " umea ezabatzerakoan. ");
			return 0;
		}
	}   
}