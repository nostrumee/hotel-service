package by.edu.hotelservice.persistence.embeddable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Builder
public class ArrivalTime {

    private LocalTime checkIn;

    private LocalTime checkOut;
}
