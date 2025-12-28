plugins {
    id("java")
    id("application") // Добавляем плагин приложения
}

group = "ru.higgradeloc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

// Указываем главный класс явно
application {
    mainClass.set("ru.higgradeloc.Main")
}

tasks.test {
    useJUnitPlatform()
}