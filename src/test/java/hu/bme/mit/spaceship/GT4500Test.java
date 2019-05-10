package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;

  private TorpedoStore primaryMock;
  private TorpedoStore secondrayMock;

  @BeforeEach
  public void init(){
    primaryMock = mock(TorpedoStore.class);
    secondrayMock = mock(TorpedoStore.class);
    this.ship = new GT4500(primaryMock, secondrayMock);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(primaryMock.isEmpty()).thenReturn(true);
    when(primaryMock.fire(1)).thenReturn(false);
    when(secondrayMock.isEmpty()).thenReturn(false);
    when(secondrayMock.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(primaryMock.isEmpty()).thenReturn(false);
    when(primaryMock.fire(1)).thenReturn(true);
    when(secondrayMock.isEmpty()).thenReturn(false);
    when(secondrayMock.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
  }

}
