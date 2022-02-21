package br.com.Nba.Playoffs.Controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.Nba.Playoffs.Dto.NbaPlayOffsDto;
import br.com.Nba.Playoffs.Model.NbaPlayOffsModel;
import br.com.Nba.Playoffs.Repository.NbaPlayOffsRepository;
import br.com.Nba.Playoffs.from.NbaPlayOffsAttForm;
import br.com.Nba.Playoffs.from.NbaPlayOffsForm;
import io.swagger.annotations.ApiOperation;

@Controller
public class NbaPlayoffsController {
	@Autowired
	private NbaPlayOffsRepository Nbarepos;

	@ResponseBody
	@GetMapping("/nba_Playoffs")
	@ApiOperation(value = "Lista todos os times que estão participando dos playoffs")	
	public Page<NbaPlayOffsDto> lista(@RequestParam(required = false) String nbatime,@PageableDefault(sort = "id", direction = Direction.ASC, page = 0 , size = 10) Pageable paginacao) {
		
		if (nbatime == null) {
			Page<NbaPlayOffsModel> nbaPlay = Nbarepos.findAll(paginacao);

			return NbaPlayOffsDto.converter(nbaPlay);
		} else {
			Page<NbaPlayOffsModel> nbaPlay = Nbarepos.findByNbatime(nbatime, paginacao);

			return NbaPlayOffsDto.converter(nbaPlay);

		}

	}

	@ResponseBody
	@GetMapping("/nba_Playoffs/{id}")
	@ApiOperation(value = "Traz um time especifico da nba")
	public NbaPlayOffsDto detalhar(@PathVariable Long id) {
		NbaPlayOffsModel nba = Nbarepos.getOne(id);
		return new NbaPlayOffsDto(nba);
	}

	@ResponseBody
	@PostMapping("/nba_Playoffs")
	@ApiOperation(value = "Adiciona um time nos playoffs")
	public ResponseEntity<NbaPlayOffsDto> cadastraUmNovoTime(@RequestBody @Valid NbaPlayOffsForm form,
			UriComponentsBuilder uriBuilder) {
		NbaPlayOffsModel nba = form.converter(Nbarepos);
		Nbarepos.save(nba);
		URI uri = uriBuilder.path("/nba_Playoffs/{id}").buildAndExpand(nba.getId()).toUri();
		return ResponseEntity.created(uri).body(new NbaPlayOffsDto(nba));
	}

	@ResponseBody
	@PutMapping("/nba_Playoffs/{id}")
	@ApiOperation(value = "Atualiza a pontuação da Serie")
	@Transactional
	public ResponseEntity<NbaPlayOffsDto> AtualizarPontuacao(@PathVariable Long id,
			@RequestBody @Valid NbaPlayOffsAttForm form) {
		NbaPlayOffsModel nba = form.atualizar(id, Nbarepos);
		return ResponseEntity.ok(new NbaPlayOffsDto(nba));
	}

	@ResponseBody
	@DeleteMapping("/nba_Playoffs/{id}")
	@ApiOperation(value = "Remove os times que perderam nos playoffs")
	public ResponseEntity<NbaPlayOffsDto> deletarUmTime(@PathVariable Long id) {
		Nbarepos.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
