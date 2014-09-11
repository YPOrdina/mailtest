import java.awt.BasicStroke;

public class DashPen extends Pen {
	private static final float DRAW_PART = 10.0F;
	private static final float DONT_DRAW_PART = 20.0F;
	private static final float[] DASH_PATTERN = new float[] {DRAW_PART, DONT_DRAW_PART};

	private float dash_phase = 0.0F;

	@Override
	protected void updateBefore(int startX, int startY, int x, int y) {
		dash_phase += Math.sqrt(Math.pow((double)(startX-x),(double)2)+Math.pow((double)(startY-y),(double)2));
	}
	
	@Override
	protected BasicStroke getStroke(int thickness) {
		return new BasicStroke(thickness,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND, 1.0F, DASH_PATTERN, this.dash_phase);
	}
}
