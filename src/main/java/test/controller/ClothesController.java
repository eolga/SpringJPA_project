package test.controller;

import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;
import test.entity.Clothes;
import test.repository.ClothesRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ControllerAll")

public class ClothesController {
    private final ClothesRepository clothesRepository;

    public ClothesController(ClothesRepository groupGoodRepository) {
        this.clothesRepository = groupGoodRepository;
    }


    @GetMapping("/clothes")
    Iterable<Clothes> getAllClothes() {
        return (List<Clothes>) clothesRepository.findAll();
    }

    @GetMapping("/clothes/{pClothesId}")
    Optional<Clothes> getClothesId(@PathVariable Integer pClothesId){
        return clothesRepository.findById(pClothesId);
    }

    @GetMapping("/clothesCreate")
    Clothes createClothes( @RequestParam(name  = "name", defaultValue = "") String name) {

        Clothes clothes = new Clothes();
        clothes.setClothesName(name);
        return clothesRepository.save(clothes);
    }

    @RequestMapping("/clothesUp")
    Clothes updateClothes(@RequestParam(name = "id", defaultValue = "") Integer id,
                          @RequestParam(name  = "name", defaultValue = "") String name) {
        Clothes clothes = new Clothes();
        if (clothesRepository.findAll().size()<id){
            clothes = createClothes(name);
        }
        else{
            Optional<Clothes> maybeCoat  = clothesRepository.findById(id);
            Clothes clothes1 = maybeCoat
                    .orElseThrow(() -> new ExpressionException(String.valueOf(id)));

            clothes1.setClothesName(name);
            clothes1 = clothes1;
            return clothesRepository.save(clothes);
        }
        return clothes;
    }

    @GetMapping("/clothesDel/{gClothesId}")
    Clothes deleteClothes (@PathVariable Integer gGroupId) throws Exception {
        Clothes clothes = clothesRepository.findById(gGroupId)
                .orElseThrow(() -> new ExpressionException(String.valueOf(gGroupId)));
        clothesRepository.delete(clothes);
        return  clothes;
    }
}
