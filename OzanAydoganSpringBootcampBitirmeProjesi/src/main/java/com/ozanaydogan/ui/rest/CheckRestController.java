package com.ozanaydogan.ui.rest;


import com.ozanaydogan.business.dto.UserDto;
import com.ozanaydogan.business.services.ICheckCreditScoreService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CheckRestController {


    @Autowired
    public ICheckCreditScoreService checkCreditScoreService;

    //http://localhost:8081/api/v1/users/citizenshipNumber/1
    @GetMapping("/users/citizenshipNumber/{citizenshipNumber}")
    public ResponseEntity<UserDto> getUserByCitizenshipNumber(@PathVariable(name="citizenshipNumber") Long citizenshipNumber) {
        UserDto userDto = checkCreditScoreService.getUserByCitizenshipNumber(citizenshipNumber.longValue());
        log.info(citizenshipNumber + " TC numarali kisi Getirildi" +userDto);
        return ResponseEntity.ok(userDto);
    }

    //http://localhost:8081/api/v1/users/citizenshipNumber/creditscore/1
    @GetMapping("/users/citizenshipNumber/creditscore/{citizenshipNumber}")
    public ResponseEntity<UserDto> getUserCreditScore(@PathVariable(name="citizenshipNumber") Long citizenshipNumber) {
        UserDto userDto = checkCreditScoreService.checkScore(citizenshipNumber.longValue());
        log.info(citizenshipNumber + "TC numarali kisinin Kredi Skoru hesaplandi"+userDto);
        return ResponseEntity.ok(userDto);
    }

}
