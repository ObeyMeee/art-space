package ua.com.andromeda.artspace.repository

import org.junit.Assert.assertEquals
import org.junit.Test
import ua.com.andromeda.artspace.R
import ua.com.andromeda.artspace.model.ArtWork

class ArtWorkRepositoryTest {
    private val target = ArtWorkRepository()

    @Test
    fun findOne() {
        val expected = ArtWork(R.drawable.art_photo_1, "Dream Girl", "Andromeda", 2023)
        val actual = target.findOne()
        assertEquals(expected, actual)
    }

    @Test
    fun findPrev_firstElement() {
        val current = ArtWork(R.drawable.art_photo_1, "Dream Girl", "Andromeda", 2023)
        val expected = ArtWork(R.drawable.art_photo_10, "Samurai among us", "Sin Co", 2021)
        val actual = target.findPrev(current)
        assertEquals(expected, actual)
    }

    @Test
    fun findPrev_anyElement() {
        val current =
            ArtWork(R.drawable.art_photo_2, "Remarkable Cyberpunk", "Symon Petlura", 1900)
        val expected = ArtWork(R.drawable.art_photo_1, "Dream Girl", "Andromeda", 2023)
        val actual = target.findPrev(current)
        assertEquals(expected, actual)
    }

    @Test
    fun findPrev_lastElement() {
        val current = ArtWork(R.drawable.art_photo_10, "Samurai among us", "Sin Co", 2021)
        val expected = ArtWork(R.drawable.art_photo_9, "My best pet", "Olena Bewildered", 2023)
        val actual = target.findPrev(current)
        assertEquals(expected, actual)
    }

    @Test
    fun findNext_firstElement() {
        val current = ArtWork(R.drawable.art_photo_1, "Dream Girl", "Andromeda", 2023)
        val expected = ArtWork(R.drawable.art_photo_2, "Remarkable Cyberpunk", "Symon Petlura", 1900)
        val actual = target.findNext(current)
        assertEquals(expected, actual)
    }

    @Test
    fun findNext_anyElement() {
        val current = ArtWork(R.drawable.art_photo_5, "Spaniel", "Lesya Ukrainka", 1900)
        val expected = ArtWork(R.drawable.art_photo_6, "Farm dog", "Pes Patron", 2022)
        val actual = target.findNext(current)
        assertEquals(expected, actual)
    }

    @Test
    fun findNext_lastElement() {
        val current = ArtWork(R.drawable.art_photo_10, "Samurai among us", "Sin Co", 2021)
        val expected = ArtWork(R.drawable.art_photo_1, "Dream Girl", "Andromeda", 2023)
        val actual = target.findNext(current)
        assertEquals(expected, actual)
    }
}