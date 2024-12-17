package eshop.domain;

import eshop.domain.*;
import eshop.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class SoldOut extends AbstractEvent {

    private Long id;
    private String productname;
    private Integer stock;
}
