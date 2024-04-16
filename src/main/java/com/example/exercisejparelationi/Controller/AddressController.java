package com.example.exercisejparelationi.Controller;

import com.example.exercisejparelationi.Api.Api;
import com.example.exercisejparelationi.DTO.AddressDTO;
import com.example.exercisejparelationi.Model.Address;
import com.example.exercisejparelationi.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAddress()
    {
        return ResponseEntity.status(200).body(addressService.getAllAddress());
    }

    @PostMapping ("/add")
    public ResponseEntity addpro(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body(new Api("Address added"));
    }

    @PutMapping("/up")
    public ResponseEntity upAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.UpAddress(addressDTO);
        return ResponseEntity.status(200).body(new Api("Address Up"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletepro(@PathVariable Integer id){

        addressService.DeleteAddress(id);
        return ResponseEntity.status(200).body("Address delete");
    }
}
