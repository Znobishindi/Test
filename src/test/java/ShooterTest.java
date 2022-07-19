
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import weapon.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import java.util.stream.Stream;


public class ShooterTest {
    Player sut;

    @BeforeAll
    public static void started() {
        System.out.println("Начат процесс тестирования");
    }

    @AfterAll
    public static void ended() {
        System.out.println("Процесс тестирования завершен");
    }

    @BeforeEach
    public void init() {
        System.out.println("Тест запущен");
        sut = new Player();
    }

    @AfterEach
    public void finished() {
        System.out.println("Тест завершен");
        sut = null;
    }
    //Проверяем на наличие исключения
    @Test
    public void nameOfGunTest() {
        int slot = 6;
        var expected = IndexOutOfBoundsException.class;
        Assertions.assertThrows(expected,
                () -> sut.nameOfGun(slot));
    }
    //Проверяем, что размер массива точно равен 5
    @ParameterizedTest
    @MethodSource("source")
    public void getSlotsCountTest(int expected) {
        int result = sut.getSlotsCount();
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of(-1), Arguments.of(0), Arguments.of(5),Arguments.of(10));
    }
    //Проверка на соответствие типа оружия ее ячейке в массиве, используя CSV
    @ParameterizedTest
    @CsvFileSource(files = "src/test/test.csv", numLinesToSkip = 1)
    public void shotWithWeaponTest(int slot, String expected) {
        String result = sut.nameOfGun(slot);
        Assertions.assertEquals(expected, result);
    }
//Дополнительное задание на hamcrest

    //Проверяем, что массив Weapon не пустой
    @Test
    public void givenArrayNotEmptyTest() {
        Weapon[] weaponArray = sut.getWeaponSlots();
        assertThat(weaponArray, not(emptyArray()));
    }
    //Проверяем, что класс Pistol наследуется от класса Weapon
    @Test
    public void extendedClassTest() {
        assertThat(Pistol.class, typeCompatibleWith(Weapon.class));
    }
    //Проверяем, что размер массива равен 5
    @Test
    public void givenArraySize5Test(){
        Weapon[] weaponArray = sut.getWeaponSlots();
        assertThat(weaponArray, arrayWithSize(5));
    }
    //проверяем, содержит ли массив Weapon ячейку 1
    @Test
    public void givenArrayHasItem1Test() {
        Weapon[] weaponArray = sut.getWeaponSlots();
        assertThat(weaponArray, hasItemInArray(sut.getWeaponSlots()[1]));
    }
    // Проверяем, что звуки выстрела из разных видов оружия не совпадают
    @Test
    public void differentShotTest() {
        String str1 = sut.shotWithWeapon(1);
        String str2 = sut.shotWithWeapon(2);
        assertThat(str1, not(str2));
    }
}
