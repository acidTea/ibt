package br.com.springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.models.Discipulado;
import br.com.springboot.repository.DiscipuladoRepository;

@RestController
@RequestMapping("/discipulado")
public class DiscipuladoController {

    @GetMapping("/")
    public String helloWorld(){
        return "tá funcionando, nego!";
    }

    @Autowired
    private DiscipuladoRepository discipuladoRepository;


    @GetMapping("/{id}")
    public Discipulado detalharGrupo(@PathVariable("id") Long id){
        System.out.println("O id é "+id);
        
        Optional<Discipulado> userFound = this.discipuladoRepository.findById(id);
        if (userFound.isPresent()){
            System.out.println("Is present");
            return userFound.get();
        }
        System.out.println("Is not present");
        return null;
    }

    @PostMapping("/add")
    public Discipulado criarGrupo(@RequestBody Discipulado discipulado){
        return this.discipuladoRepository.save(discipulado);
    }

@GetMapping("/listAll")    
public List<Discipulado> list(){
    return this.discipuladoRepository.findAll();
}

@DeleteMapping("/delete/{id}")
public void deleteGrupo(@PathVariable("id") Long id){
    Optional<Discipulado> userFound = this.discipuladoRepository.findById(id);
    if (userFound.isPresent()){
        System.out.println("Is present");
        Discipulado grupo = userFound.get();
        grupo.setStatus("D");
        this.discipuladoRepository.save(grupo);
    }
}


}
