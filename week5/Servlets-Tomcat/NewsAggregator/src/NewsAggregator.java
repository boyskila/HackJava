import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

@WebServlet("/")
public class NewsAggregator extends HttpServlet {
		private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		SyndFeed feed = new SyndFeedImpl();
		List<URL> urls = new ArrayList<>();
		urls.add(new URL("http://www.dnevnik.bg/rssc/?rubrid=1698"));
		urls.add(new URL("http://www.dnevnik.bg/rssc/?rubrid=1932"));
		urls.add(new URL("http://www.dnevnik.bg/rssc/?rubrid=1692"));
		SyndFeedInput input = new SyndFeedInput();
		for (URL url2 : urls) {
			try {
				feed = input.build(new XmlReader(url2));
				res.setContentType("application/xml; charset=UTF-8");
				readHtml(feed, res);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (FeedException e) {
				e.printStackTrace();
			}
		}
	}

	private void readHtml(SyndFeed feed, HttpServletResponse res)
			throws IOException {
		Iterator<SyndFeed> it = feed.getEntries().iterator();
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		out.println("<h1>" + feed.getTitle() + "</h1>");
		while (it.hasNext()) {
			SyndEntry entry = (SyndEntry) it.next();
			out.println("<li><a href= " + entry.getLink() + ">"
					+ entry.getDescription() + "</a></li>");
		}
	}
}
