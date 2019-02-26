package pabloaraya.org.data.entity;

import com.google.gson.annotations.SerializedName;

public class MovieEntity {

  @SerializedName("Title")
  public String title;

  @SerializedName("Poster")
  public String poster;
}
