package repo.api


actual class JsonLoader actual constructor() {
    actual fun loadJsonFile(fileName: String): String? = dummyNewsJson
// TODO: Create actual code to read Raw files

//        return javaClass.classLoader?.getResourceAsStream(fileName).use { stream ->
//             InputStreamReader(stream).use { reader ->
//                 reader.readText()
//             }
//         }
//
//    }
}