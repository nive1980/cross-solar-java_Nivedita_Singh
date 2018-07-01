package com.crossover.techtrial.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * HourlyElectricity is responsible for electricity generated by a Panel in an
 * hour.
 *
 * @author Crossover
 *
 */

@Entity
@Table(name = "hourly_electricity")
public class HourlyElectricity implements Serializable {

  private static final long serialVersionUID = -575347909928592140L;

  @Id
  @JsonIgnore
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "panel_id", referencedColumnName = "id")
  Panel panel;

  @JsonProperty("generated_electricity")
  @NotNull
  @Column(name = "generated_electricity")
  Long generatedElectricity;

  @JsonProperty("reading_at")
  @NotNull
  @Column(name = "reading_at")
  LocalDateTime readingAt;

  protected HourlyElectricity() {
    this(null, null, null);
  }

  private HourlyElectricity(Panel panel, @NotNull Long generatedElectricity, @NotNull LocalDateTime readingAt) {
    this.panel = panel;
    this.generatedElectricity = generatedElectricity;
    this.readingAt = readingAt;
  }

  public static HourlyElectricity of(Panel panel, Long generatedElectricity, LocalDateTime readingAt) {
    return new HourlyElectricity(panel, generatedElectricity, readingAt);
  }

  public Long getId() {
    return id;
  }

  public Panel getPanel() {
    return panel;
  }

  public void setPanel(Panel panel) {
    this.panel = panel;
  }

  public Long getGeneratedElectricity() {
    return generatedElectricity;
  }

  public LocalDateTime getReadingAt() {
    return readingAt;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((readingAt == null) ? 0 : readingAt.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    HourlyElectricity other = (HourlyElectricity) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (readingAt == null) {
      if (other.readingAt != null) {
        return false;
      }
    } else if (!readingAt.equals(other.readingAt)) {
      return false;
    }
    return true;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "HourlyElectricity [id=" + id + ", panel=" + panel + ", generatedElectricity=" + generatedElectricity
            + ", readingAt=" + readingAt + "]";
  }
}

