package com.challenge.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LineData(Long userId, String userName, Long orderId,
                       Long productId, BigDecimal productValue, LocalDate orderDate) {}
