import org.scalatest.flatspec.AnyFlatSpec
import java.nio.file.FileSystems
import scala.language.postfixOps


class TestContentSearch extends AnyFlatSpec{

  "ContentSearch(\"./src\")" should "give List(())" in {
    val obj = ContentSearch("./src")
    assert(obj.result == List("()"))
  }

  "Path Valid or not " should "give" in {
    val path = FileSystems.getDefault.getPath("./src")
    assert(path.toFile.isDirectory && path.toFile.exists())
  }

  " ContentSearch(\"./src/mai\")" should "give List(./src/mai) because path doesn't exists " in {
    val obj: ContentSearch = ContentSearch("./src/mai") // this path doesn't exists
    assert(obj.result == List("Path doesn't exists !"))
  }

}
