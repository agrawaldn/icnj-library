alter table media drop index media_uk;

CREATE UNIQUE INDEX `media_uk` ON `media` (`title` ASC, `media_category_id` ASC, `volume_nb` ASC) ;