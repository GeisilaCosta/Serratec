package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
