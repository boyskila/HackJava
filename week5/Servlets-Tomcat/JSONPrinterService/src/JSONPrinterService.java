import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@WebServlet("/")
public class JSONPrinterService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse res)
			throws IOException, ServletException {
		res.setContentType("text/plain; charset=UTF-8");
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet("https://hackbulgaria.com/api/checkins/");
		CloseableHttpResponse response = null;
		StringBuilder content = new StringBuilder();
		try {
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			String line = null;
			try (BufferedReader br = new BufferedReader(new InputStreamReader(
					entity.getContent()));) {
				while ((line = br.readLine()) != null) {
					content.append(line);
				}
			}
		} finally {
			response.close();
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(content.toString());
		String prettyJsonString = gson.toJson(je);
		res.getWriter().println(prettyJsonString);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse res)
			throws ServletException, IOException {
	}
}
