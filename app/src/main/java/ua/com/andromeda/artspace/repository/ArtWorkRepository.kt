package ua.com.andromeda.artspace.repository

import ua.com.andromeda.artspace.R
import ua.com.andromeda.artspace.model.ArtWork

class ArtWorkRepository {
    private val artWorks: List<ArtWork> = listOf(
        ArtWork(R.drawable.art_photo_1, "Dream Girl", "Andromeda", 2023),
        ArtWork(R.drawable.art_photo_2, "Remarkable Cyberpunk", "Symon Petlura", 1900),
        ArtWork(R.drawable.art_photo_3, "Easy-going Stephanie", "Zakhar Berkut", 1834),
        ArtWork(R.drawable.art_photo_4, "Anime cat", "Taras Shevchenko", 1855),
        ArtWork(R.drawable.art_photo_5, "Spaniel", "Lesya Ukrainka", 1900),
        ArtWork(R.drawable.art_photo_6, "Farm dog", "Pes Patron", 2022),
        ArtWork(R.drawable.art_photo_7, "Theory of relativity", "Albert Einstein", 1900),
        ArtWork(R.drawable.art_photo_8, "Best friends", "Mykola Parasiuk", 2020),
        ArtWork(R.drawable.art_photo_9, "My best pet", "Olena Bewildered", 2023),
        ArtWork(R.drawable.art_photo_10, "Samurai among us", "Sin Co", 2021),
    ).shuffled()

    fun findOne(): ArtWork {
        return artWorks.first()
    }

    fun findNext(current: ArtWork): ArtWork {
        val currentIndex = artWorks.indexOf(current)
        return if (currentIndex == artWorks.lastIndex) {
            artWorks.first()
        } else artWorks[currentIndex + 1]
    }

    fun findPrev(current: ArtWork): ArtWork {
        val currentIndex = artWorks.indexOf(current)
        return if (currentIndex == 0) {
            artWorks.last()
        } else artWorks[currentIndex - 1]
    }

}