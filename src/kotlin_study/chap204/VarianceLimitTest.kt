package kotlin_study.chap204

open class Animal(val size: Int)

class Cat(val jump: Int) : Animal(50)

class Spider(val poison: Boolean) : Animal(1)

class Box2<T>   //무변성

class Box3<out T: Animal>(val element: T) { //공변성, Animal 자료형으로만 제한
    fun getAnimal(): T = element
//    fun setAnimal(new: T) { //공변성일 때는 매개변수에 제네릭 사용불가, 반환값에서만 사용가능
//        element = new  //역으로 역공변성일때는 반환값에 제네릭 사용불가, 매개변수에는 사용가능
//    }
}

fun main() {
    val c1 = Cat(10)
    val s1 = Spider(true)

    var a1: Animal = c1
    a1 = s1
    println("S1 ${a1.size} ${a1.poison}")

    val b1 = Box2<Animal>()
//    val b2: Box2<Animal> = Box2<Cat>() 무변성이라 에러
    val b2: Box3<Animal> = Box3<Cat>(c1)  //공변성이라 가능
    val b3 = Box2<Spider>()

}