package org.nasdanika.html;

/**
 * Interface for creating Font Awesome (http://fortawesome.github.io/Font-Awesome/) styled UI elements.
 * @author Pavel Vlasov
 *
 */
public interface FontAwesome<T extends UIElement<?>> {
	
	String VERSION = "4.2.0";

	enum WebApplication {
		adjust, anchor, archive, area_chart, arrows, arrows_h, arrows_v, asterisk, at, automobile, ban, bank, bar_chart, bar_chart_o, barcode, bars, beer, bell, bell_o, bell_slash, bell_slash_o, bicycle, binoculars, birthday_cake, bolt, bomb, book, bookmark, bookmark_o, briefcase, bug, building, building_o, bullhorn, bullseye, bus, cab, calculator, calendar, calendar_o, camera, camera_retro, car, caret_square_o_down, caret_square_o_left, caret_square_o_right, caret_square_o_up, cc, certificate, check, check_circle, check_circle_o, check_square, check_square_o, child, circle, circle_o, circle_o_notch, circle_thin, clock_o, close, cloud, cloud_download, cloud_upload, code, code_fork, coffee, cog, cogs, comment, comment_o, comments, comments_o, compass, copyright, credit_card, crop, crosshairs, cube, cubes, cutlery, dashboard, database, desktop, dot_circle_o, download, edit, ellipsis_h, ellipsis_v, envelope, envelope_o, envelope_square, eraser, exchange, exclamation, exclamation_circle, exclamation_triangle, external_link, external_link_square, eye, eye_slash, eyedropper, fax, female, fighter_jet, file_archive_o, file_audio_o, file_code_o, file_excel_o, file_image_o, file_movie_o, file_pdf_o, file_photo_o, file_picture_o, file_powerpoint_o, file_sound_o, file_video_o, file_word_o, file_zip_o, film, filter, fire, fire_extinguisher, flag, flag_checkered, flag_o, flash, flask, folder, folder_o, folder_open, folder_open_o, frown_o, futbol_o, gamepad, gavel, gear, gears, gift, glass, globe, graduation_cap, group, hdd_o, headphones, heart, heart_o, history, home, image, inbox, info, info_circle, institution, key, keyboard_o, language, laptop, leaf, legal, lemon_o, level_down, level_up, life_bouy, life_buoy, life_ring, life_saver, lightbulb_o, line_chart, location_arrow, lock, magic, magnet, mail_forward, mail_reply, mail_reply_all, male, map_marker, meh_o, microphone, microphone_slash, minus, minus_circle, minus_square, minus_square_o, mobile, mobile_phone, money, moon_o, mortar_board, music, navicon, newspaper_o, paint_brush, paper_plane, paper_plane_o, paw, pencil, pencil_square, pencil_square_o, phone, phone_square, photo, picture_o, pie_chart, plane, plug, plus, plus_circle, plus_square, plus_square_o, power_off, print, puzzle_piece, qrcode, question, question_circle, quote_left, quote_right, random, recycle, refresh, remove, reorder, reply, reply_all, retweet, road, rocket, rss, rss_square, search, search_minus, search_plus, send, send_o, share, share_alt, share_alt_square, share_square, share_square_o, shield, shopping_cart, sign_in, sign_out, signal, sitemap, sliders, smile_o, soccer_ball_o, sort, sort_alpha_asc, sort_alpha_desc, sort_amount_asc, sort_amount_desc, sort_asc, sort_desc, sort_down, sort_numeric_asc, sort_numeric_desc, sort_up, space_shuttle, spinner, spoon, square, square_o, star, star_half, star_half_empty, star_half_full, star_half_o, star_o, suitcase, sun_o, support, tablet, tachometer, tag, tags, tasks, taxi, terminal, thumb_tack, thumbs_down, thumbs_o_down, thumbs_o_up, thumbs_up, ticket, times, times_circle, times_circle_o, tint, toggle_down, toggle_left, toggle_off, toggle_on, toggle_right, toggle_up, trash, trash_o, tree, trophy, truck, tty, umbrella, university, unlock, unlock_alt, unsorted, upload, user, users, video_camera, volume_down, volume_off, volume_up, warning, wheelchair, wifi, wrench
	}

	enum FileType {
		file, file_archive_o, file_audio_o, file_code_o, file_excel_o, file_image_o, file_movie_o, file_o, file_pdf_o, file_photo_o, file_picture_o, file_powerpoint_o, file_sound_o, file_text, file_text_o, file_video_o, file_word_o, file_zip_o
	}

	enum Spinner {
		circle_o_notch, cog, gear, refresh, spinner
	}

	enum FormControl {
		check_square, check_square_o, circle, circle_o, dot_circle_o, minus_square, minus_square_o, plus_square, plus_square_o, square, square_o
	}

	enum Payment {
		cc_amex, cc_discover, cc_mastercard, cc_paypal, cc_stripe, cc_visa, credit_card, google_wallet, paypal
	}

	enum Chart {
		area_chart, bar_chart, bar_chart_o, line_chart, pie_chart
	}

	enum Currency {
		bitcoin, btc, cny, dollar, eur, euro, gbp, ils, inr, jpy, krw, money, rmb, rouble, rub, ruble, rupee, shekel, sheqel, try_, turkish_lira, usd, won, yen
	}

	enum Directional {
		angle_double_down, angle_double_left, angle_double_right, angle_double_up, angle_down, angle_left, angle_right, angle_up, arrow_circle_down, arrow_circle_left, arrow_circle_o_down, arrow_circle_o_left, arrow_circle_o_right, arrow_circle_o_up, arrow_circle_right, arrow_circle_up, arrow_down, arrow_left, arrow_right, arrow_up, arrows, arrows_alt, arrows_h, arrows_v, caret_down, caret_left, caret_right, caret_square_o_down, caret_square_o_left, caret_square_o_right, caret_square_o_up, caret_up, chevron_circle_down, chevron_circle_left, chevron_circle_right, chevron_circle_up, chevron_down, chevron_left, chevron_right, chevron_up, hand_o_down, hand_o_left, hand_o_right, hand_o_up, long_arrow_down, long_arrow_left, long_arrow_right, long_arrow_up, toggle_down, toggle_left, toggle_right, toggle_up
	}

	enum VideoPlayer {
		arrows_alt, backward, compress, eject, expand, fast_backward, fast_forward, forward, pause, play, play_circle, play_circle_o, step_backward, step_forward, stop, youtube_play
	}

	enum Brand {
		adn, android, angellist, apple, behance, behance_square, bitbucket, bitbucket_square, bitcoin, btc, cc_amex, cc_discover, cc_mastercard, cc_paypal, cc_stripe, cc_visa, codepen, css3, delicious, deviantart, digg, dribbble, dropbox, drupal, empire, facebook, facebook_square, flickr, foursquare, ge, git, git_square, github, github_alt, github_square, gittip, google, google_plus, google_plus_square, google_wallet, hacker_news, html5, instagram, ioxhost, joomla, jsfiddle, lastfm, lastfm_square, linkedin, linkedin_square, linux, maxcdn, meanpath, openid, pagelines, paypal, pied_piper, pied_piper_alt, pinterest, pinterest_square, qq, ra, rebel, reddit, reddit_square, renren, share_alt, share_alt_square, skype, slack, slideshare, soundcloud, spotify, stack_exchange, stack_overflow, steam, steam_square, stumbleupon, stumbleupon_circle, tencent_weibo, trello, tumblr, tumblr_square, twitch, twitter, twitter_square, vimeo_square, vine, vk, wechat, weibo, weixin, windows, wordpress, xing, xing_square, yahoo, yelp, youtube, youtube_play, youtube_square
	}

	enum Medical {
		ambulance, h_square, hospital_o, medkit, plus_square, stethoscope, user_md, wheelchair
	}
	
	T getTarget();
	
	FontAwesome<T> custom(String custom);
	FontAwesome<T> brand(Brand brand);
	FontAwesome<T> chart(Chart chart);
	FontAwesome<T> currency(Currency currency);
	FontAwesome<T> directional(Directional directional);
	FontAwesome<T> fileType(FileType fileType);
	FontAwesome<T> formControl(FormControl formControl);
	FontAwesome<T> medical(Medical medical);
	FontAwesome<T> payment(Payment payment);
	FontAwesome<T> spinner(Spinner spinner);
	FontAwesome<T> videoPlayer(VideoPlayer videoPlayer);
	FontAwesome<T> webApplication(WebApplication webApplication);
	
	FontAwesome<T> fixedWidth();
	
	/**
	 * Adds fa-li class for list items.
	 * @return
	 */
	FontAwesome<T> li();
	
	/**
	 * Adds fa-ul for unordered lists.
	 * @return
	 */
	FontAwesome<T> ul();

	FontAwesome<T> pullLeft();
	
	FontAwesome<T> pullRight();
	
	enum Size { large, x2, x3, x4, x5 }
	
	FontAwesome<T> size(Size size);

	FontAwesome<T> spin();
	
	enum Rotate { R90, R180, R270 }
	
	FontAwesome<T> rotate(Rotate rotate);
	
	enum Flip { horizontal, vertical }
	
	FontAwesome<T> flip(Flip flip);
	
	
	interface Stack extends AutoCloseable {
		
		enum IconSize { x1, x2, x3, x4, x5 }
	
		Stack icon(UIElement<?> icon, IconSize size, boolean inverse);
		
		Stack icon(FontAwesome<?> icon, IconSize size, boolean inverse);
		
		Stack size(Size size);
		
	}
	
	FontAwesome<T> style(UIElement.Style style);

}