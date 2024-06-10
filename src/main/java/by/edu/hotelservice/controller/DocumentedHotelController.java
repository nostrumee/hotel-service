package by.edu.hotelservice.controller;

import by.edu.hotelservice.dto.filter.HotelFilter;
import by.edu.hotelservice.dto.request.HotelCreateRequest;
import by.edu.hotelservice.dto.response.HotelResponse;
import by.edu.hotelservice.dto.response.HotelShortResponse;
import by.edu.hotelservice.dto.response.error.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@Tag(name = "Hotel Controller", description = "Hotels API")
public interface DocumentedHotelController {

    @Operation(summary = "Get a hotel by id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Hotel found",
                    content = {
                            @Content(schema = @Schema(implementation = HotelResponse.class))
                    }),
            @ApiResponse(
                    responseCode = "404", description = "Hotel not found",
                    content = {
                            @Content(schema = @Schema(implementation = ErrorResponse.class))
                    })
    })
    HotelResponse getHotelById(long id);

    @Operation(summary = "Get all hotels")
    @ApiResponse(
            responseCode = "200", description = "Hotels found",
            content = {
                    @Content(schema = @Schema(implementation = HotelShortResponse.class))
            })
    List<HotelShortResponse> getAllHotels();

    @Operation(summary = "Create a hotel")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201", description = "Hotel created",
                    content = {
                            @Content(schema = @Schema(implementation = HotelResponse.class))
                    }),
            @ApiResponse(
                    responseCode = "400", description = "Invalid data provided",
                    content = {
                            @Content(schema = @Schema(implementation = ErrorResponse.class))
                    })
    })
    ResponseEntity<HotelShortResponse> createHotel(
            HotelCreateRequest createRequest,
            UriComponentsBuilder uriComponentsBuilder
    );

    @Operation(summary = "Add amenities to the hotel")
    @ApiResponse(responseCode = "200", description = "Amenities added")
    void addAmenitiesToHotel(long id, List<String> amenities);

    @Operation(summary = "Search hotels with filter")
    @ApiResponse(
            responseCode = "200", description = "Hotels found",
            content = {
                    @Content(schema = @Schema(implementation = HotelShortResponse.class))
            })
    List<HotelShortResponse> searchHotels(HotelFilter filter);

    @Operation(summary = "Get histogram by parameter")
    @ApiResponse(
            responseCode = "200",
            description = "Histogram data retrieved successfully"
    )
    Map<String, Long> getHistogram(String param);
}
