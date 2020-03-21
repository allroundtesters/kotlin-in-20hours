import kotlin.browser.document

fun main() {
    document.write("Hello, world!")
    document.bgColor="red"
    render(document.getElementById("root")) {
        h1 {
            + "Hello,React Web Application"
        }
        div {
            h3 {
                + "TODO 1"
            }
            p{
                +"NEW ITEM1"
            }
        }
        div {
            h3 {
                + "TODO2"
            }
            p {
                + "TOM Jerry"
            }
        }
        div {
            h1 {
                + "John Doe"
            }
            img  {
                attrs {
                    src = "http://www.baidu.com"
                }
            }
        }
    }
}