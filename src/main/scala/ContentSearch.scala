import scala.concurrent.ExecutionContext.Implicits.global
import scala.jdk.CollectionConverters.IteratorHasAsScala
import java.nio.file.{FileSystems, Files}
import scala.language.postfixOps
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.DurationInt

case class ContentSearch (path:String) {

  val result: List[String] = Await.result(ContentSearch(path), 100 milli)

  def ContentSearch (pathDir : String): Future[List[String]] = Future {
    val path = FileSystems.getDefault.getPath(pathDir)

    if (path.toFile.isDirectory || path.toFile.exists()) {
      List(Files.walk(path).iterator().asScala.foreach(println).toString)
    }
    else {
      List("Path doesn't exists !")
    }
  }
}
