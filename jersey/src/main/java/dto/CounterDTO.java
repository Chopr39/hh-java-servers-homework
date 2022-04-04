package dto;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.time.LocalDateTime;

public class CounterDTO {
  private final LocalDateTime date;
  private final int value;

  public CounterDTO(int value) {
    this.date = LocalDateTime.now();
    this.value = value;
  }
  @JsonGetter("date")
  public String getDate() {
    return date.toString();
  }
  @JsonGetter("value")
  public int getValue() {
    return value;
  }
}
