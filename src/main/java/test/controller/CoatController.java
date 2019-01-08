package test.controller;

import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;
import test.entity.Clothes;
import test.entity.Coat;
import test.repository.ClothesRepository;
import test.repository.CoatRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("ControllerAll")
public class CoatController {
    private final CoatRepository coatRepository;
    private final ClothesRepository clothesRepository;
    private Random random = new Random();

    public CoatController(CoatRepository coatRepository, ClothesRepository clothesRepository) {
        this.coatRepository = coatRepository;
        this.clothesRepository = clothesRepository;
    }


    @GetMapping("/coat")
    Iterable<Coat> getAllCoat() {
        return (List<Coat>) coatRepository.findAll();
    }

    @GetMapping("/coat/{CoatId}")
    Optional<Coat> getId(@PathVariable Integer Id){
        return coatRepository.findById(Id);
    }

    @RequestMapping("/coatCreate")
    Coat createCoat(@RequestParam(name = "idClothes", defaultValue = "") Integer id,
                      @RequestParam(name  = "name", defaultValue = "") String name,
                      @RequestParam(name  = "price", defaultValue = "") Integer price) {
        Coat coat = new Coat();
        Optional<Clothes> maybeClothes  = clothesRepository.findById(id);
        Clothes  clothes = maybeClothes
                .orElseThrow(() -> new ExpressionException(String.valueOf(id)));

        clothes.setCoat(new HashSet<Coat>());
        coat.setClothes(clothes);
        coat.setClothes(name);
        coat.setClothes(price);
        clothes.getCoat().add(coat);
        return coatRepository.save(coat);

    }

    @RequestMapping("/coatUp")
    Coat updateCoat(@RequestParam(name = "id", defaultValue = "") Integer id,
                      @RequestParam(name = "idClothes", defaultValue = "") Integer idg,
                      @RequestParam(name  = "name", defaultValue = "") String name,
                      @RequestParam(name  = "price", defaultValue = "") Integer price) {
        Coat coat1 = new Coat();
        if (coatRepository.findAll().size()<id){
            coat1 = createCoat(id,name ,price);
        }
        else{
            Optional<Coat> maybeGoods  = coatRepository.findById(id);
            Coat coat = maybeGoods
                    .orElseThrow(() -> new ExpressionException(String.valueOf(id)));
            coat.setCoatName(name);
            coat.setCoatPrice(price);
            coat1 = coat;
            return coatRepository.save(coat);
        }
        return coat1;
    }

    @GetMapping("/Delcoat/{gCoatId}")
    Coat deleteCoat(@PathVariable Integer gCoatId) throws Exception {
        Coat coat = coatRepository.findById(gCoatId)
                .orElseThrow(() -> new ExpressionException(String.valueOf(gCoatId)));
        coatRepository.delete(coat);
        return  coat;

    }
}
