/*
Copyright 2008-2011 Gephi
Authors : Antonio Patriarca <antoniopatriarca@gmail.com>
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
*/

package org.gephi.visualization.data.graph;

import org.gephi.math.Vec3;
import org.gephi.visualization.api.color.Color;

/**
 * Immutable 3D node representation used by the rendering engine.
 *
 * @author Antonio Patriarca <antoniopatriarca@gmail.com>
 */
public final class VizNode3D {

    public final Vec3 position;
    
    public final float size;
    
    public final Color color;
    
    public VizNode3D(Vec3 position, float size, Color color) {
        this.position = position;
        this.size = size;
        this.color = color;
    }
}