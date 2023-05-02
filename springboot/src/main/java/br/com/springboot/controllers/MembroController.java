package br.com.springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.models.Discipulado;
import br.com.springboot.models.Membro;
import br.com.springboot.repository.DiscipuladoRepository;
import br.com.springboot.repository.MembroRepository;

@RestController
@RequestMapping("/membros")
public class MembroController {

    @GetMapping("/")
    public String helloWorld(){
        return "Oi brasil!";
    }

    @Autowired
    private MembroRepository membroRepository;

    @Autowired
    private DiscipuladoRepository discipuladoRepository;
    
    @GetMapping("/{id}")
    public Membro user(@PathVariable("id") Long id){
        System.out.println("O id é "+id);
        
        Optional<Membro> userFound = this.membroRepository.findById(id);
        if (userFound.isPresent()){
            System.out.println("Is present");
            return userFound.get();
        }
        System.out.println("Is not present");
        return null;
    }

    @PostMapping("/add")
    public Membro criarMembro(@RequestBody Membro membro){
        return this.membroRepository.save(membro);
    }

@GetMapping("/listAll")    
public List<Membro> list(){
    return this.membroRepository.findAll();
}

@DeleteMapping("/delete/{id}")
public void deleteUser(@PathVariable("id") Long id){
    Optional<Membro> userFound = this.membroRepository.findById(id);
    if (userFound.isPresent()){
        System.out.println("Is present");
        Membro membro = userFound.get();
        membro.setStatus("D");
        this.membroRepository.save(membro);
    }
}

@PutMapping("/associar/{id}/{idGrupo}")
    public Membro associarMembroGrupo(@PathVariable("id") Long id, @PathVariable("idGrupo") Long idGrupo){
        Optional<Membro> userFound = this.membroRepository.findById(id);
        Optional<Discipulado> groupFound = this.discipuladoRepository.findById(idGrupo);

        if (userFound.isPresent() && groupFound.isPresent()){
            Membro membro = userFound.get();
            membro.setDiscipulado(groupFound.get());
            return this.membroRepository.save(membro);
        }
        return null;
        
    }

}
