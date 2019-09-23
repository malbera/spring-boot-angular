package com.globomatics.bike;

import org.springframework.data.jpa.repository.JpaRepository;

interface BikeRepository extends JpaRepository<Bike, Long> {
}
