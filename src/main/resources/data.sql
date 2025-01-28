/*WITH new_posts AS (
INSERT INTO public.posts (is_draft, likes, title, description, category)
VALUES
    (FALSE, 0, 'Mesh trui', 'Dit is een omschrijving van een post over een trui', 'truien'),
    (FALSE, 0, 'Gekleurde sjaal', 'Dit is een omschrijving van een post over een sjaal.', 'Sjaals'),
    (FALSE, 0, 'Gestreepte muts', 'Dit is een omschrijving van een post over een muts.', 'mutsen'),
    (FALSE, 0, 'Handtas', 'Dit is een omschrijving van een post over een tas.', 'tassen')
    RETURNING id, title
    )
INSERT INTO public.images (post_id, file_name, url)
VALUES
    ((SELECT id FROM new_posts WHERE title = 'Mesh trui'), 'image1.jpg', 'https://i.pinimg.com/736x/99/2d/88/992d8856e234a57e57c52e58bad68a0f.jpg'),
    ((SELECT id FROM new_posts WHERE title = 'Gekleurde sjaal'), 'image2.jpg', 'https://i.pinimg.com/736x/db/bf/6a/dbbf6a512c7248db041c26af2e99ba2b.jpg'),
    ((SELECT id FROM new_posts WHERE title = 'Gestreepte muts'), 'image3.jpg', 'https://i.pinimg.com/736x/4c/9d/fe/4c9dfebc152a0eed4a03e18864a72951.jpg'),
    ((SELECT id FROM new_posts WHERE title = 'Handtas'), 'image4.jpg', 'https://i.pinimg.com/736x/27/0e/68/270e68edd4412eb8ff100e4f8ea59855.jpg');*/


/*wachtwoord voor haker: haker1iscool*/
/*wachtwoord voor patroonmaker: patroonmaker1*/
INSERT INTO users (username, password, role, email, biography) VALUES ('haker', '$2a$10$hQ2NaTEuDGAIVlYPmmoBQOvzY6C2QOVhXW4tsWQnM9NXQjZB8p7Ue', 'HAKER', 'haker@email.com', 'bio van een haker');
INSERT INTO users (username, password, role, email, biography) VALUES ('patroonmaker', '$2a$10$269PRnQcWu8I6elFvtaoouGLJCUfMSKEKhIpeh99/igt7.44kLY6S', 'PATROONMAKER', 'patroonmaker@email.com', 'bio van een patroonmaker');