package pabloaraya.org.data.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ResponseEntity {

  @SerializedName("Search")
  public List<MovieEntity> movieEntities;
}
