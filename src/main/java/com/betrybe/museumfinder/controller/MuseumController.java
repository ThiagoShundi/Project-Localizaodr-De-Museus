package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class MuseumController.
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {
  private  final MuseumServiceInterface museumServiceInterface;

  @Autowired
  public MuseumController(MuseumServiceInterface museumServiceInterface) {
    this.museumServiceInterface = museumServiceInterface;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Museum createMuseum(@RequestBody Museum museum) {
    return museumServiceInterface.createMuseum(museum);
  }

  @GetMapping("/closest")
  @ResponseStatus(HttpStatus.OK)
  public Museum getClosestMuseum(
      @RequestParam(name = "lat") double latitude,
      @RequestParam(name = "lng") double longitude,
      @RequestParam(name = "max_dist_km") double maxDistance) {
    Coordinate coordinate = new Coordinate(latitude, longitude);
    return museumServiceInterface.getClosestMuseum(coordinate, maxDistance);
  }
}
